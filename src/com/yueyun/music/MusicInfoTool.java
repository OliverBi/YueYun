package com.yueyun.music;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import com.yueyun.dao.TbAlbum;
import com.yueyun.dao.TbAlbumDAO;
import com.yueyun.dao.TbArtist;
import com.yueyun.dao.TbArtistDAO;
import com.yueyun.dao.TbTrack;
import com.yueyun.dao.TbTrackDAO;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;
import de.umass.lastfm.Track;

public class MusicInfoTool {

	private static String musicSrcDir;
	
	// key=fa1c42ba67a0b9f68b5102efc82b30da
	private static String lastFmKey;

	public static String getMusicSrcDir() {
		return musicSrcDir;
	}

	public static void setMusicSrcDir(String musicSrcDir) {
		MusicInfoTool.musicSrcDir = musicSrcDir;
	}

	public static String getLastFmKey() {
		return lastFmKey;
	}

	public static void setLastFmKey(String lastFmKey) {
		MusicInfoTool.lastFmKey = lastFmKey;
	}

	public static void getMusicInfo(){
		File musicDir = new File(MusicInfoTool.musicSrcDir);
		if(musicDir.exists()){
			for(File musicFile : musicDir.listFiles()){
				String musicFileFullName = musicFile.getName();
				String musicFileName = musicFileFullName.split("\\.")[0];
				String musicName = musicFileName.split("-")[0];
				String musicArtistName = musicFileName.split("-")[1];
				Track track = Track.getInfo(musicArtistName, musicName, MusicInfoTool.lastFmKey);
				TbTrack tbTrack = null;
				if(track != null){
					tbTrack = new TbTrack();
					tbTrack.setTrackId(track.getMbid());
					tbTrack.setTrackName(track.getName());
					tbTrack.setTrackDuration(track.getDuration());
					
					Artist artist = Artist.getInfo(musicArtistName, MusicInfoTool.lastFmKey);
					TbArtist tbArtist = null;
					if(artist != null){
						tbArtist = new TbArtist();
						tbArtist.setArtistId(artist.getMbid());
						tbArtist.setArtistName(artist.getName());
						tbArtist.setArtistImgSmall(artist.getImageURL(ImageSize.SMALL));
						tbArtist.setArtistImgMedium(artist.getImageURL(ImageSize.MEDIUM));
						tbArtist.setArtistImgLarge(artist.getImageURL(ImageSize.LARGE));
						
						TbArtistDAO tbArtistDAO = new TbArtistDAO();
						List<TbArtist> artistList = tbArtistDAO.findByExample(tbArtist);
						if(artistList == null || artistList.size() <= 0){
							tbArtistDAO.save(tbArtist);
						}
					}
					
					String albumName = track.getAlbum();
					TbAlbum tbAlbum = null;
					if(albumName != null){
						Album album = Album.getInfo(musicArtistName, albumName, MusicInfoTool.lastFmKey);
						if(album != null){
							tbAlbum = new TbAlbum();
							tbAlbum.setAlbumId(album.getMbid());
							tbAlbum.setAlbumName(album.getName());
							tbAlbum.setReleaseDate(new Timestamp(album.getReleaseDate().getTime()));
							tbAlbum.setAlbumImgSmall(album.getImageURL(ImageSize.SMALL));
							tbAlbum.setAlbumImgMedium(album.getImageURL(ImageSize.MEDIUM));
							tbAlbum.setAlbumImgLarge(album.getImageURL(ImageSize.LARGE));
							
							TbAlbumDAO tbAlbumDAO = new TbAlbumDAO();
							List<TbAlbum> albumList = tbAlbumDAO.findByExample(tbAlbum);
							if(albumList == null || albumList.size() <= 0){
								tbAlbumDAO.save(tbAlbum);
							}
						}
					}
					
					if(tbArtist != null)
						tbTrack.setTbArtist(tbArtist);
					if(tbAlbum != null)
						tbTrack.setTbAlbum(tbAlbum);
					TbTrackDAO tbTrackDAO = new TbTrackDAO();
					List<TbTrack> trackList = tbTrackDAO.findByExample(tbTrack);
					if(trackList == null || trackList.size() <= 0){
						tbTrackDAO.save(tbTrack);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MusicInfoTool.setLastFmKey("fa1c42ba67a0b9f68b5102efc82b30da");
		MusicInfoTool.setMusicSrcDir("D:\\music");
		MusicInfoTool.getMusicInfo();
	}
}
