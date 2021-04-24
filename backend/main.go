package webview

import (
	"strings"
)

// Turn arrays into null joined
// strings, which can be seperated
// once it has entered Java code.
func array(array []string) string {
	return strings.Join(array, "\000")
}

// Called from Java
func Test() string {
	return "Hello, Gomobile"
}
