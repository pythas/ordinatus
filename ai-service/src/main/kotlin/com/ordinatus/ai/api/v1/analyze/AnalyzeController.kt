package com.ordinatus.ai.api.v1.analyze

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AnalyzeController {
    @GetMapping("/")
    fun test(): String {
        return "hello bech"
    }
}