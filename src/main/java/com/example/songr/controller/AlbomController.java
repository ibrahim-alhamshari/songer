package com.example.songr.controller;

import com.example.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbomController {

    @GetMapping("/albums")
    public String getAlbums(Model model){
        List<Album> listAlbum = new ArrayList<>();
        Album first = new Album("Thriller" , "Michael Jackson", 70 , 200 , "https://images.indianexpress.com/2020/05/shutter-island-1200.jpg");
        Album second = new Album("Back in Black" , "Hard rock", 50 , 130 , "https://images.genius.com/d137724702414708ed0d504c75023be0.1000x1000x1.jpg");
        Album third = new Album("The Dark Side of the Moon" , "Pink Floyd", 56 , 142 , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1406471514l/11475458.jpg");
        listAlbum.add(first);
        listAlbum.add(second);
        listAlbum.add(third);
        model.addAttribute("listAlbum", listAlbum);
        return "alboms.html";
    }
}
