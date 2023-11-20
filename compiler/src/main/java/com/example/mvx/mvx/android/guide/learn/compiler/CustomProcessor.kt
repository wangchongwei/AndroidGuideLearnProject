package com.example.mvx.mvx.android.guide.learn.compiler

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic



class CustomProcessor : AbstractProcessor() {

    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        var message = processingEnv.messager
        message.printMessage(Diagnostic.Kind.NOTE, "=========================")

        return false
    }
}