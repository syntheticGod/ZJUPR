

package presentation.ita1;

public class TimeGetTest {

	public static void main(String args[]){
		System.out.print(TimeGetter.getToday());
		
		System.out.print(TimeGetter.getDayBefore(20));
		System.out.print(TimeGetter.getYear());
		System.out.println(TimeGetter.getDAY_OF_WEEK("2016-03-19"));
		System.out.println(TimeGetter.getDayBefore("2015-10-15", 78));
	
	}
	
	
}

