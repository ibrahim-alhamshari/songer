package com.example.songr.controller;

import com.example.songr.Album;
import com.example.songr.AlbumInterface;
import com.example.songr.Song;
import com.example.songr.SongInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    SongInterface songInterface;

    @Autowired
    AlbumInterface albumInterface;



    @GetMapping("/allSongs")
    public String getAlbums(@PathVariable String id, Model model
                            ){
        System.out.println(id);
        model.addAttribute("listSongs", songInterface.findAll());

        Album album = albumInterface.findById(Integer.parseInt(id)).get();
        model.addAttribute("listAlbumFinal" , album);
        return "songs.html";
    }



    @GetMapping("/songs")
    public String getSong(){
        return "songs.html";
    }

    @PostMapping("/saveSong")
    public RedirectView saveSongToDataBase(@RequestParam (value = "title")String title ,
                                           @RequestParam(value = "length")int length,
                                           @RequestParam(value = "trackNumber") int trackNumber,
                                           @RequestParam(value = "albumId") Integer albumId
                                           ){
    Album album = albumInterface.findById(albumId).get();
    Song song = new Song(title, length,trackNumber , album);
    songInterface.save(song);

    return new RedirectView("/allSongs?id="+ albumId);
}
}
