package com.learncoding.eworkloadapi.exception

class BadResourceException(msg: String) : Exception(msg) {

    var errorMessages = arrayListOf<String>()

    fun addErrorMessage(msg: String) : Unit {
        errorMessages.add(msg);
    }

}