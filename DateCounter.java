public class DateCounter {

    public static void main(String[] args){
        try{

            if(args.length == 0){
                throw new NullPointerException();
            }

            int arg0 = Integer.parseInt(args[0]);
            int arg1 = Integer.parseInt(args[1]);
            int arg2 = Integer.parseInt(args[2]);
            int arg3 = Integer.parseInt(args[3]);
            int arg4 = Integer.parseInt(args[4]);
            int arg5 = Integer.parseInt(args[5]);

            if(!isValidDate(arg0, arg1, arg2) || !isValidDate(arg3, arg4, arg5)){
                throw new Exception();
            }


            System.out.println("Number of days between " + arg0 + " " + arg1 + " " + arg2 + " and " + arg3 + " " + arg4 + " " + arg5 + " is: "+ daysBetween(arg0, arg1, arg2, arg3, arg4, arg5));
        }

        catch(NullPointerException e){
            System.out.println("Usage: java DateCounter <year0> <month0> <day0> <year1> <month1> <day1>");
        }

        catch(Exception e){
            System.out.println("One or more of the supplied dates is not valid.");
        }
       
    }


	public static boolean isLeapYear(int year){

		if (year % 4 == 0) {

			if (year % 100 == 0) {

        	   if(year%400 == 0){
        	       return true;

        	   } 
        	   else {
        	       return false;
        	   }

            }
            else{
            	return true;
            }
        } 
        else{
        	return false;
        }
	}

    public static int daysInMonth(int year, int month){

        if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }

        else if(month == 2){
            if(isLeapYear(year)){
                return 29;
            }
            else{
                return 28;

            }
        }

        else {
            return 31;
        }
    }

    public static boolean isValidDate(int year, int month, int day){

        boolean isValidYear = false;
        boolean isValidMonth = false;
        boolean isValidDay = false;

        if(year > 0){
            isValidYear = true;
        }

        if(month == 4 || month == 6 || month == 9 || month == 11){
            isValidMonth = true;
            if(day > 0 && day <= 30){
                isValidDay = true;
            }
        }

        else if(month == 2){
            isValidMonth = true;
            if(isLeapYear(year)){
                if(day > 0 && day <= 29){
                    isValidDay = true;
                }
            }
            else{
                if(day > 0 && day <= 28){
                    isValidDay = true;
                }
            }

        }

        else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            isValidMonth = true;
            if(day > 0 && day<=31){
                isValidDay = true;
            }
        }

        return isValidYear && isValidMonth && isValidDay;
    }

    public static int daysBetween(int year0, int month0, int day0, int year1, int month1, int day1){

        if(year1 < year0 || year1 == year0){
            int temp = year1;
            year1 = year0;
            year0 = temp;
            if (month1 < month0 || month1 == month0){
                temp = month0;
                month0 = month1;
                month1 = temp;
                if(day1 < day0 || day1 == day0){
                    temp = day0;
                    day0 = day1;
                    day1 = temp;
                }
            }
        }

        int daysBetween = 0;

        while(!((year0 == year1) && (month0 == month1) && (day0 == day1))) {

            daysBetween++;
            day0++;
            
            if(!isValidDate(year0, month0, day0)) {

                day0 = 1;
                month0++;

                if(!isValidDate(year0, month0, day0)) {
                    month0 = 1;
                    year0++;
                }   
            }
        }

        return daysBetween;

    }

    public static boolean hasLeapSecondInJune(int year) {
        return year == 1972 || year == 1981 || year == 1982 || year == 1983 || year == 1985 || year == 1992 || year == 1993 || year == 1994 || year == 1997 || year == 2012 || year == 2015;
    }

    public static boolean hasLeapSecondInDecember(int year) {
        return year == 1972 || year == 1973 || year == 1974 || year == 1975 || year == 1976 || year == 1977 || year == 1978 || year == 1979 || year == 1987 || year == 1989 || year == 1990 || year == 1995 || year == 1998 || year == 2005 || year == 2008;
    }
    
    public static boolean hasLeapSecond(int year){
        return hasLeapSecondInDecember(year) || hasLeapSecondInJune(year);
    }

    public static boolean hasLeapSecond(int year, int month, int day) {
        if(hasLeapSecondInJune(year) && (month == 6) && (day == 30)){
            return true;
        }

        else if((hasLeapSecondInDecember(year)) && (month == 12) && (day == 31)){
            return true;
        }

        return false;

    }

}
