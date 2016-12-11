package magelle.rss.domain

interface EntryCatalog {

    fun latest() : List<Entry>

}