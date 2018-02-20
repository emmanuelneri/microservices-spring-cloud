import { Component, OnInit } from '@angular/core';
import { FileService } from "./file.service";
import { File } from "./file"

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesComponent implements OnInit {

  private files: File[] = [];

  constructor(private fileService: FileService) { }

  ngOnInit() {
    this.findFiles();
  }

  private findFiles() {
    this.fileService.findAll().subscribe(data => {
      this.files = data
    });
  }

}
