/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.LanguageDao;
import az.nadir.library.model.Language;
import az.nadir.library.service.LanguageService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private LanguageDao languageDao;

    @Override
    public List<Language> getLanguageList() throws Exception {
        return languageDao.getLanguageList();
    }

    @Override
    public void addLanguage(Language language) throws Exception {
        languageDao.addLanguage(language);
    }

    @Override
    public Language getLanguageById(Long languageLong) throws Exception {
        return languageDao.getLanguageById(languageLong);
    }

    @Override
    public void updateLanguage(Language language) throws Exception {
        languageDao.updateLanguage(language);
    }

    @Override
    public void deleteLanguage(Long languageId) throws Exception {
        languageDao.deleteLanguage(languageId);
    }

    @Override
    public List<Language> searchLanguageData(String keyWord) throws Exception {
        return languageDao.searchLanguageData(keyWord);
    }

}
