all:
	@echo "usage: $(MAKE) <fetch|generate>" >&2

fetch apidoc.txt:
	./fetch-apidoc.sh https://apidocs.theforeman.org/foreman/3.4/apidoc/v2.html | tee apidoc.txt


generate api_defs.clj: apidoc.txt
	./gen-clojure-funcs.sh apidoc.txt | tee api_defs.swp
	mv -f api_defs.swp api_defs.clj

clean:
	-rm -f *~ *.swp

.PHONY: all clean fetch generate
