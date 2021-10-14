package com.example.songr.controller;

import com.example.songr.Album;
import com.example.songr.AlbumInterface;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.tsohr.CDL;
import com.github.tsohr.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AlbomController {

    @Autowired
    AlbumInterface albumInterface;

    @GetMapping("/albums")
    public String getAlbums(Model model){
//        List<Album> listAlbum = new ArrayList<>();
//        Album first = new Album("Thriller" , "Michael Jackson", 70 , 200 , "https://images.indianexpress.com/2020/05/shutter-island-1200.jpg");
//        Album second = new Album("Back in Black" , "Hard rock", 50 , 130 , "https://images.genius.com/d137724702414708ed0d504c75023be0.1000x1000x1.jpg");
//        Album third = new Album("The Dark Side of the Moon" , "Pink Floyd", 56 , 142 , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1406471514l/11475458.jpg");
//        listAlbum.add(first);
//        listAlbum.add(second);
//        listAlbum.add(third);

        Album album = new Album();

        model.addAttribute("listAlbum", albumInterface.findAll());

        System.out.println(albumInterface.findAll());
        return "alboms.html";
    }

    @JsonIgnore
    @GetMapping("/data")
    public String getData(){
//        System.out.println("A request is sent by ReactJs ");
        StringBuilder builder = new StringBuilder("artist, title, img, length \n");

        for (Album album : albumInterface.findAll()) {
        builder.append(album.getArtist()).append(", ")
                .append(album.getTitle()).append(", ")
                .append(album.getImageUrl()).append(", ")
                .append(album.getLength()).append("\n");
        }
        JSONArray jsonArray= CDL.toJSONArray(String.valueOf(builder));
//        System.out.println(jsonArray);

        return jsonArray.toString();
    }

    @GetMapping("/dataForm")
    public String getFromForm(){
        return "dataForm.html";
    }

    @PostMapping("/saveAlbum")
    public RedirectView saveToDataBase(@ModelAttribute Album album , Model model){
       model.addAttribute("album", album);
      albumInterface.save(album);
//        System.out.println("====================="+album.getId());
        return new RedirectView("/albums");
    }
}
