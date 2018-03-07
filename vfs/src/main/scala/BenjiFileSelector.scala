/*
 * Copyright (C) 2018-2018 Zengularity SA (FaberNovel Technologies) <https://www.zengularity.com>
 */

package com.zengularity.benji.vfs

import org.apache.commons.vfs2.{ FileSelectInfo, FileType, FileTypeSelector }

private[vfs] class BenjiFileSelector(fileType: FileType) extends FileTypeSelector(fileType) {
  override def includeFile(fileInfo: FileSelectInfo): Boolean = {
    super.includeFile(fileInfo) && fileInfo.getFile.getName.getExtension != "metadata"
  }
}