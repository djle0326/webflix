package com.webflix.controller.popularDrama;

import java.util.Map;

import org.json.simple.JSONArray;

import com.webflix.controller.Controller;
import com.webflix.service.DramaService;
import com.webflix.service.api.Drama.DramaHttpRequest;
import com.webflix.service.api.Drama.DramaJsonParser;
import com.webflix.service.api.Drama.TmdbDramaService;

public class PopularDrama implements Controller{
	
    private DramaService dramaService;

    public PopularDrama() {
        this.dramaService = new TmdbDramaService(new DramaHttpRequest(), new DramaJsonParser());
    }

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String sortBy = paramMap.getOrDefault("sort_by", "popularity.desc");
        try {
            JSONArray dramas = dramaService.getSortedDramas(sortBy);
            model.put("dramas", dramas);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error", "Unable to fetch dramas");
        }
        return "popular-drama";
	}
	
}
