all: go java

help:
	@echo "make         Build Go + Java"
	@echo "make go      Build Go only"
	@echo "make java    Build Java only"

go:
	@gomobile bind -v -o app/webview.aar -target=android ./backend/

java:
	@gradle build

# Thanks to https://github.com/golang/go/issues/37961#issuecomment-673854585
# For recommendations
# These may or may not work
init:
	@go mod init gowebview
	@go mod tidy
	@unset GO111MODULE
	@unset GOMOD
	@go env -w GO111MODULE=auto

clean:
	@rm -rf app/*-sources.jar app/*.aar

.PHONY: clean init java go help all
