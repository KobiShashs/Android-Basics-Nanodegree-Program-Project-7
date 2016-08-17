package newsfeed;

/**
 * Created by user on 8/16/2016.
 */
public class NewsItem {
    private String mTitle;
    private String mSection;
    private long mTimeInMilliseconds;
    private String mUrl;

    public NewsItem(String mTitle, String mSection, long mTimeInMilliseconds, String mUrl) {
        setmTitle(mTitle);
        setmSection(mSection);
        setmTimeInMilliseconds(mTimeInMilliseconds);
        setmUrl(mUrl);
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setmTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSection() {
        return mSection;
    }

    public void setmSection(String mSection) {
        this.mSection = mSection;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }


}
