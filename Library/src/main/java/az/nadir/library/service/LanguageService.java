/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service;

import az.nadir.library.model.Language;

import java.util.List;

/**
 * @author Asus
 */
public interface LanguageService {

    List<Language> getLanguageList() throws Exception;

    void addLanguage(Language language) throws Exception;

    Language getLanguageById(Long languageLong) throws Exception;

    void updateLanguage(Language language) throws Exception;

    void deleteLanguage(Long languageId) throws Exception;

    List<Language> searchLanguageData(String keyWord) throws Exception;
}
