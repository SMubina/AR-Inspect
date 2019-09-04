package com.example.facts.model



data class CanadaFacts(
        val title:String?= "title",
        val rows: List<RowsData>?= ArrayList()
)