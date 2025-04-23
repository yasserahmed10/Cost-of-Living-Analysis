package org.example.data

import java.io.File

class CsvFileReader(private val csvFile: File) {
    fun readLinesFromFile():List<String> {
        return csvFile.readLines()
    }
}