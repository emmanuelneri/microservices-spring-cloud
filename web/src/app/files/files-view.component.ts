import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FileService } from "./file.service";
import { File } from "./file"

@Component({
  selector: 'app-files-view',
  templateUrl: './files-view.component.html',
  styleUrls: ['./files.component.css']
})
export class FilesViewComponent implements OnInit {

  private file: File;

  constructor(private route: ActivatedRoute, private fileService: FileService) {
    this.file = new File();
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.findById(id);
  }

  private findById(id) {
    this.fileService.findById(id).subscribe(data => {
      this.file = data
    });
  }

}
