package com.yg.library

import org.apache.spark.sql.DataFrame

class Utils {
  def saveData(df: DataFrame,dbName:String,tableName:String,save_path:String,saveMode:String="overwrite",format:String="parquet"): Unit ={
    df.write.
      option("path",save_path).
      format(format).
      mode(saveMode).
      saveAsTable(s"${dbName}.${tableName}")
  }
}
