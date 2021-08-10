package com.example.songr;

import org.springframework.data.repository.CrudRepository;

public interface AlbumInterface extends CrudRepository<Album, Integer> {
}
