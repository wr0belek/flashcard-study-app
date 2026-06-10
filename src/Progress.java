public class Progress {
    int points = 0;
    int level = 0;
    public void improve(int points)
    {
        this.points += points;
        if((this.points >> 6)  >= (1 << level)) //level = max(0, log_2(points) - 5)
            level++;
    }
    public int getLevel()
    {
        return this.level;
    }
    public int getPoints()
    {
        return this.points;
    }
}
