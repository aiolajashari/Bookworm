package com.bookworm.bookworm.Api.Model;

/**
 * Created by Valdrin on 2/7/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Doc {

    public Doc()
    {

    }

    public Doc(int id,String title,String author,String imagePath)
    {
        Id=id;
        titleSuggest=title;
        authorName=new ArrayList<>();
        authorName.add(author);
        coverEditionKey=imagePath;
    }

    @SerializedName("title_suggest")
    @Expose
    private String titleSuggest;
    @SerializedName("edition_key")
    @Expose
    private List<String> editionKey = null;
    @SerializedName("cover_i")
    @Expose
    private Integer coverI;
    @SerializedName("isbn")
    @Expose
    private List<String> isbn = null;
    @SerializedName("has_fulltext")
    @Expose
    private Boolean hasFulltext;
    @SerializedName("text")
    @Expose
    private List<String> text = null;
    @SerializedName("author_name")
    @Expose
    private List<String> authorName = null;
    @SerializedName("contributor")
    @Expose
    private List<String> contributor = null;
    @SerializedName("ia_loaded_id")
    @Expose
    private List<String> iaLoadedId = null;
    @SerializedName("seed")
    @Expose
    private List<String> seed = null;
    @SerializedName("oclc")
    @Expose
    private List<String> oclc = null;
    @SerializedName("id_google")
    @Expose
    private List<String> idGoogle = null;
    @SerializedName("ia")
    @Expose
    private List<String> ia = null;
    @SerializedName("author_key")
    @Expose
    private List<String> authorKey = null;
    @SerializedName("subject")
    @Expose
    private List<String> subject = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lending_identifier_s")
    @Expose
    private String lendingIdentifierS;
    @SerializedName("ia_collection_s")
    @Expose
    private String iaCollectionS;
    @SerializedName("first_publish_year")
    @Expose
    private Integer firstPublishYear;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("ebook_count_i")
    @Expose
    private Integer ebookCountI;
    @SerializedName("publish_place")
    @Expose
    private List<String> publishPlace = null;
    @SerializedName("ia_box_id")
    @Expose
    private List<String> iaBoxId = null;
    @SerializedName("edition_count")
    @Expose
    private Integer editionCount;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("id_goodreads")
    @Expose
    private List<String> idGoodreads = null;
    @SerializedName("author_alternative_name")
    @Expose
    private List<String> authorAlternativeName = null;
    @SerializedName("public_scan_b")
    @Expose
    private Boolean publicScanB;
    @SerializedName("id_overdrive")
    @Expose
    private List<String> idOverdrive = null;
    @SerializedName("publisher")
    @Expose
    private List<String> publisher = null;
    @SerializedName("id_canadian_national_library_archive")
    @Expose
    private List<String> idCanadianNationalLibraryArchive = null;
    @SerializedName("language")
    @Expose
    private List<String> language = null;
    @SerializedName("lccn")
    @Expose
    private List<String> lccn = null;
    @SerializedName("last_modified_i")
    @Expose
    private Integer lastModifiedI;
    @SerializedName("lending_edition_s")
    @Expose
    private String lendingEditionS;
    @SerializedName("id_librarything")
    @Expose
    private List<String> idLibrarything = null;
    @SerializedName("cover_edition_key")
    @Expose
    private String coverEditionKey;
    @SerializedName("person")
    @Expose
    private List<String> person = null;
    @SerializedName("publish_year")
    @Expose
    private List<Integer> publishYear = null;
    @SerializedName("printdisabled_s")
    @Expose
    private String printdisabledS;
    @SerializedName("place")
    @Expose
    private List<String> place = null;
    @SerializedName("time")
    @Expose
    private List<String> time = null;
    @SerializedName("publish_date")
    @Expose
    private List<String> publishDate = null;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private int Id;


    public String getTitleSuggest() {
        return titleSuggest;
    }

    public void setTitleSuggest(String titleSuggest) {
        this.titleSuggest = titleSuggest;
    }

    public List<String> getEditionKey() {
        return editionKey;
    }

    public void setEditionKey(List<String> editionKey) {
        this.editionKey = editionKey;
    }

    public Integer getCoverI() {
        return coverI;
    }

    public void setCoverI(Integer coverI) {
        this.coverI = coverI;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public Boolean getHasFulltext() {
        return hasFulltext;
    }

    public void setHasFulltext(Boolean hasFulltext) {
        this.hasFulltext = hasFulltext;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public List<String> getContributor() {
        return contributor;
    }

    public void setContributor(List<String> contributor) {
        this.contributor = contributor;
    }

    public List<String> getIaLoadedId() {
        return iaLoadedId;
    }

    public void setIaLoadedId(List<String> iaLoadedId) {
        this.iaLoadedId = iaLoadedId;
    }

    public List<String> getSeed() {
        return seed;
    }

    public void setSeed(List<String> seed) {
        this.seed = seed;
    }

    public List<String> getOclc() {
        return oclc;
    }

    public void setOclc(List<String> oclc) {
        this.oclc = oclc;
    }

    public List<String> getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(List<String> idGoogle) {
        this.idGoogle = idGoogle;
    }

    public List<String> getIa() {
        return ia;
    }

    public void setIa(List<String> ia) {
        this.ia = ia;
    }

    public List<String> getAuthorKey() {
        return authorKey;
    }

    public void setAuthorKey(List<String> authorKey) {
        this.authorKey = authorKey;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLendingIdentifierS() {
        return lendingIdentifierS;
    }

    public void setLendingIdentifierS(String lendingIdentifierS) {
        this.lendingIdentifierS = lendingIdentifierS;
    }

    public String getIaCollectionS() {
        return iaCollectionS;
    }

    public void setIaCollectionS(String iaCollectionS) {
        this.iaCollectionS = iaCollectionS;
    }

    public Integer getFirstPublishYear() {
        return firstPublishYear;
    }

    public void setFirstPublishYear(Integer firstPublishYear) {
        this.firstPublishYear = firstPublishYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEbookCountI() {
        return ebookCountI;
    }

    public void setEbookCountI(Integer ebookCountI) {
        this.ebookCountI = ebookCountI;
    }

    public List<String> getPublishPlace() {
        return publishPlace;
    }

    public void setPublishPlace(List<String> publishPlace) {
        this.publishPlace = publishPlace;
    }

    public List<String> getIaBoxId() {
        return iaBoxId;
    }

    public void setIaBoxId(List<String> iaBoxId) {
        this.iaBoxId = iaBoxId;
    }

    public Integer getEditionCount() {
        return editionCount;
    }

    public void setEditionCount(Integer editionCount) {
        this.editionCount = editionCount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getIdGoodreads() {
        return idGoodreads;
    }

    public void setIdGoodreads(List<String> idGoodreads) {
        this.idGoodreads = idGoodreads;
    }

    public List<String> getAuthorAlternativeName() {
        return authorAlternativeName;
    }

    public void setAuthorAlternativeName(List<String> authorAlternativeName) {
        this.authorAlternativeName = authorAlternativeName;
    }

    public Boolean getPublicScanB() {
        return publicScanB;
    }

    public void setPublicScanB(Boolean publicScanB) {
        this.publicScanB = publicScanB;
    }

    public List<String> getIdOverdrive() {
        return idOverdrive;
    }

    public void setIdOverdrive(List<String> idOverdrive) {
        this.idOverdrive = idOverdrive;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public List<String> getIdCanadianNationalLibraryArchive() {
        return idCanadianNationalLibraryArchive;
    }

    public void setIdCanadianNationalLibraryArchive(List<String> idCanadianNationalLibraryArchive) {
        this.idCanadianNationalLibraryArchive = idCanadianNationalLibraryArchive;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getLccn() {
        return lccn;
    }

    public void setLccn(List<String> lccn) {
        this.lccn = lccn;
    }

    public Integer getLastModifiedI() {
        return lastModifiedI;
    }

    public void setLastModifiedI(Integer lastModifiedI) {
        this.lastModifiedI = lastModifiedI;
    }

    public String getLendingEditionS() {
        return lendingEditionS;
    }

    public void setLendingEditionS(String lendingEditionS) {
        this.lendingEditionS = lendingEditionS;
    }

    public List<String> getIdLibrarything() {
        return idLibrarything;
    }

    public void setIdLibrarything(List<String> idLibrarything) {
        this.idLibrarything = idLibrarything;
    }

    public String getCoverEditionKey() {
        return coverEditionKey;
    }

    public void setCoverEditionKey(String coverEditionKey) {
        this.coverEditionKey = coverEditionKey;
    }

    public List<String> getPerson() {
        return person;
    }

    public void setPerson(List<String> person) {
        this.person = person;
    }

    public List<Integer> getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(List<Integer> publishYear) {
        this.publishYear = publishYear;
    }

    public String getPrintdisabledS() {
        return printdisabledS;
    }

    public void setPrintdisabledS(String printdisabledS) {
        this.printdisabledS = printdisabledS;
    }

    public List<String> getPlace() {
        return place;
    }

    public void setPlace(List<String> place) {
        this.place = place;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<String> getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(List<String> publishDate) {
        this.publishDate = publishDate;
    }

    public String getLargeCoverUrl(){
        return "http://covers.openlibrary.org/b/olid/"+getCoverEditionKey()+"-M.jpg?default=false";
    }

}