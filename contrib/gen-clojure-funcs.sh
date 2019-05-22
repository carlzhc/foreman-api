#!/bin/bash
# from foreman api document, generate functions for clojure

if [ ! -e "$1" ]; then
    echo "usage: $0 apidoc-txt-dump" >&2
    exit 1
fi

apidoc="$1"
# 1. retrive only the "GET POST PUT DELETE" methods
methodfile=$(mktemp)
trap "rm -f $methodfile" EXIT

egrep '^(GET|POST|PUT|DELETE)' "$apidoc" > $methodfile

# 2. remove any "'s " from the file
sed -i -re "s/'s / /g" $methodfile
sed -i -re 's/\s*$//' $methodfile
sed -i -re '/DEPRECATED/d' $methodfile

# 3. reformat the file
cat $methodfile | while read method url desc; do
    args=(`echo $url | egrep -o ":\w+" | tr -d :` )
    argurl=$(echo "$url" | sed -re 's#:\w+#%s#g')
    if [ -z "$desc" ]; then
        case "$method" in
            GET) desc="List" ;;
            POST) desc="Create" ;;
            PUT) desc="Update" ;;
            DELETE) desc="Delete" ;;
        esac

        case ${#args} in
            0) desc="$desc of $(echo ${argurl#/api/} | tr _/ ' ')" ;;
            1) desc="$desc of $(echo "$argurl" | awk -F/ '{print $4, "per", $3}' | tr _/ ' ')" ;;
            *) desc="$desc $(echo "$argurl" | awk -F/ '{print $5, "for a", $3}' | tr _/ ' ')" ;;
        esac
    fi

    cat <<EOF
(defapi $(echo ${desc// /-} | sed 's/,.*//' | tr A-Z/ a-z-)
  "${desc}"
  :${method}
EOF

    echo -n "  \"${argurl}\""
    if [ ${#args} -eq 0 ]; then
        echo ")"
    else
        echo -e "\n  ${args[*]})"
    fi
    echo
done
