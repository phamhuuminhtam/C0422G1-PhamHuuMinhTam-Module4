package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {
        List<Music> music = musicService.findAll();
        model.addAttribute("musics", music);
        return "/index";
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusic().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getName(),musicForm.getSinger(),musicForm.getKind(),fileName);
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", new MusicForm());
        return modelAndView;
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id,Model model){
        model.addAttribute("music",musicService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public  String editMusicInfo(@ModelAttribute Music music){
        musicService.update(music);
        return "redirect:/music/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        musicService.remove(id);
        return "redirect:/music/";
    }
}