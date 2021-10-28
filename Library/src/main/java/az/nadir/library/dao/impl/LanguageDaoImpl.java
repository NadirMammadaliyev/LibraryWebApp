/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.LanguageDao;
import az.nadir.library.model.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class LanguageDaoImpl implements LanguageDao {

    @Override
    public List<Language> getLanguageList() throws Exception {
        List<Language> languageList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM LANGUAGE WHERE ACTIVE=1";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {
            if (c != null) {
                while (rs.next()) {
                    Language language = new Language();
                    language.setId(rs.getLong("ID"));
                    language.setName(rs.getString("NAME"));
                    languageList.add(language);
                }

            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return languageList;
    }

    @Override
    public void addLanguage(Language language) throws Exception {
        String sql = "INSERT INTO LANGUAGE (ID,NAME) \n"
                + "VALUES(LANGUAGE_SEQ.NEXTVAL,?) ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, language.getName());
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Language getLanguageById(Long languageLong) throws Exception {
        Language language = new Language();
        String sql = "SELECT ID,NAME FROM LANGUAGE\n"
                + "WHERE ACTIVE =1 AND ID =?";
        ResultSet rs = null;
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, languageLong);
            rs = ps.executeQuery();
            if (rs.next()) {
                language.setId(rs.getLong("ID"));
                language.setName(rs.getString("NAME"));

            } else {
                language = null;
            }

        }
        return language;
    }

    @Override
    public void updateLanguage(Language language) throws Exception {
        String sql = "UPDATE LANGUAGE SET NAME =? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, language.getName());
            ps.setLong(2, language.getId());
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteLanguage(Long languageId) throws Exception {
        String sql = "UPDATE LANGUAGE SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, languageId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Language> searchLanguageData(String keyWord) throws Exception {
        List<Language> languageList = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT ID, NAME FROM LANGUAGE WHERE ACTIVE = 1 AND (LOWER (NAME) LIKE LOWER (?)) ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Language language = new Language();
                language.setId(rs.getLong("ID"));
                language.setName(rs.getString("NAME"));
                languageList.add(language);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return languageList;
    }


}
