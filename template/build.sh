#!/bin/bash
echo Building Go...

# Link this to your repo
gomobile bind -o app/webview.aar github.com/pufflegamerz/gowebviewex

echo Done, now building APK...
./gradlew build

# Add any other things you would like to run after building
# (like adb installing the apk)
