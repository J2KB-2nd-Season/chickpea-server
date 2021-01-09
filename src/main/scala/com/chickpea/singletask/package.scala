package com.chickpea.singletask

import java.sql.Timestamp
import java.util.Date

import com.roundeights.hasher.Implicits._

import com.chickpea.util.ISO8601

package object singletasks {

    case class ForResponseSingleTasks(singleTasks: Seq[SingleTaskForResponse])

    case class SingleTaskForResponse( title: String,
                                      description: String,
                                      createdAt: String,
                                      updatedAt: String
                                      /*user: Profile*/)
}