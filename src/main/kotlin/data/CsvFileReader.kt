package org.example.data

import org.example.model.City
import java.io.File

class CsvFileReader(private val csvFile: File) {
    fun readLinesFromFile():List<String> {
        return csvFile.readLines()
    }
}