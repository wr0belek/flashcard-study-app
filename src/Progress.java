public class Progress {
    private int points = 0;
    private int level = 0;
    public void improve(int points)
    {
        this.points += points;
        if((this.points >> 5)  >= (1 << level)) //level = max(0, log_2(points) - 4)
        {
            level++;
            System.out.println("Congratulations! You've reached level " + level + "!");
        }
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
