import { Component, OnInit } from '@angular/core';
import { FileService } from "./file.service";
import { File } from "./file"
import dataPageUtil from "../dataPageUtil";

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesComponent implements OnInit {

  private files: File[] = [];
  private page: number = 1;
  private pageSize: number = dataPageUtil.getPageSize();
  private totalElements: number = 0;

  constructor(private fileService: FileService) { }

  ngOnInit() {
    this.findFiles();
  }

  private findFiles() {
    this.fileService.findAllPaged(this.page, this.pageSize).subscribe(data => {
      this.files = data.content;
      this.totalElements = data.totalElements;
    });
  }

  public loadPage(page: number) {
    this.page = page;
    this.findFiles();
  }

}
