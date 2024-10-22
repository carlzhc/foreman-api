#!/bin/bash

# given a satellite/foreman api url, fetch it and save it as api-doc
function usage {
    local code=${1:-1}
    if [[ $code != 0 ]]; then
        exec >&2
    fi

    printf "Usage: $0 [options...] <url>...\n"
    printf "\n"
    printf "Options:\n"
    printf "  %-10s%s\n" "-h" "Show help message"
    exit $code
}

function main {
    set -euo pipefail
    local urls=() curl="curl -q -sSfk"
    while getopts "h:" opt "$@"; do
        case $opt in
            h) usage 0 ;;
            u) urls+=("$OPTARG") ;;
            -) break ;;
            *) usage 1 ;;
        esac
    done

    shift $((OPTIND-1))

    if ! [[ ${urls[@]} ]]; then
        if [[ ${1-} ]]; then
            urls=("$@")
        else
            usage 1
        fi
    fi

    trap "rm -f apidoc.txt.swp" EXIT
    $curl "${urls[@]}" |
        sed -n -e '/<tbody>/, /<\/tbody>/p' |
        sed -r \
            -e 's#></td>#>@@@</td>#g' \
            -e 's#<[^>]*>##g' \
            -e '/^ *$/d' \
            -e 's/^ *//' \
            -e 's/^(get|post|put|delete) /\U\1/' |
        sed -r -n -e '/^(GET|POST|PUT|DELETE) /{N;/DEPRECATED/{N;d};s/[.,] .*//;s/\n/ /p}' |
        awk 'NF > 2 {print}' > apidoc.txt.swp

    local m= u= d= ret=
    while read m u d; do
        if [[ $d = @@@ ]]; then
            if ! grep -F "$m $u" apidoc-amend.txt; then
                echo "$m $u $d"
                echo "warn: method have not a description for '$m $u'" >&2
                let "ret+=1"
            fi
        else
            echo "$m $u $d"
        fi
    done <apidoc.txt.swp
    exit $ret
}


if [[ $0 = $BASH_SOURCE ]]; then
    main "$@"
fi
