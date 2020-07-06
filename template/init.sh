#!/bin/bash
echo Input app name \(My Epic App\)
read appname
echo Input app ID \(com.mojang.minecraft\)
read appid
echo Replacing...

grep -rl --exclude='*.sh' __APPNAME__ | parallel sed -i "s/__APPNAME__/$appname/g" {}
grep -rl --exclude='*.sh' __APPID__ | parallel sed -i "s/__APPID__/$appid/g" {}
echo Done.
