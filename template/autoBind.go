// This tool can be used to autobind functions
// It inserts them into the Java file and will
// soon generate them
package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"strings"
	"os"
)

func main() {
	generated :=
	`@JavascriptInterface
	public void toast(String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	@JavascriptInterface
    public String test() {
        return Webview.test();
    }`;

	path, _ := os.Getwd()
	fileName := path + "/app/src/main/java/MainActivity.java"
	code, err := ioutil.ReadFile(fileName)
    if err != nil {
        log.Fatalln(err)
    }

	// Split between the comments
	str := string(code)
	start := strings.Split(str, "//STARTGENERATE\n")
	end := strings.Split(start[1], "//ENDGENERATE")

	// Generate a neat replacement
	newFile :=
		start[0] +
		"//STARTGENERATE\n" +
		generated +
		"\n		//ENDGENERATE" +
		end[1]

	// Write back to the file
	err = ioutil.WriteFile(fileName, []byte(newFile), 0644)
    if err != nil {
        log.Fatalln(err)
    }

	fmt.Println("Everything worked, cool")
}
