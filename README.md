# Go Android WebView
Write Android apps in HTML/CSS/JS with a Golang backend.  
This uses the native Android webview.

## To start:
`make`

## Requirements
1. Gomobile
2. Android SDK

## Tips
To change the icon:  
`app/src/main/res/drawable`  
To add HTML files:  
`app/src/main/assets`  
Change app name and ID:  
`app/src/build.gradle` and `app/src/main/AndroidManifest.xml`  
Add Java function routers:  
`app/src/main/java/MainActivity.java`  
