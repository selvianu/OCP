package self.practise;

public class SecondAndMinuteChallenge {

	public static void main(String[] args) {
getDurationString(46, 90);
	}

	public static String getDurationString(int minutes, int seconds)
	{
		if(minutes<0)
			return "invalid Value";
		else
		{
			if ((seconds<0)||(seconds>59))
			{
				int hours=minutes*3600;
				System.out.println(hours+" HH "+minutes+" M "+seconds+"ss ");
			}
			else
				return "invalid value";
		}
		return null;
			
	}

}
