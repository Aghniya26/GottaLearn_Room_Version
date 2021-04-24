package com.example.gottalearn_beta

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Assignment")
data class Assignment (
@PrimaryKey @ColumnInfo (name = "title") var title: String,
@ColumnInfo(name = "description") var description: String,
@ColumnInfo(name="date") var date: String,
@ColumnInfo(name="priority") var priority: String,
@ColumnInfo(name = "subject") var subject: String
)

