
package com.flexcode.gdsckabarak.common.utils


fun String.isNameValid(): Boolean {
    return this.isNotBlank()
}

fun String.isValidPassword(): Boolean {
    return this.isNotBlank() &&
        this.length >= 6
}

