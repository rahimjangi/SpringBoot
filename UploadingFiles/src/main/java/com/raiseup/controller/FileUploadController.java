package com.raiseup.controller;

import com.raiseup.storage.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FileUploadController {
    private final StorageService storageService;

    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        var files=storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(
                                FileUploadController.class,
                                "serveFile",
                                path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList());

        model.addAttribute("files",files);
      log.info("LoadAllFiles: {}",files);
        return "uploadForm";
    }
}
