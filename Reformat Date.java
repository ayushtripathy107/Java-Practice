class Solution {
    public String reformatDate(String date) {
        // Split the string into components: [Day, Month, Year]
        String[] parts = date.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        
        // 1. Process Day: Remove the 2-letter suffix ("st", "nd", "rd", "th")
        String dayNum = day.substring(0, day.length() - 2);
        if (dayNum.length() == 1) {
            dayNum = "0" + dayNum; // Pad single digit days with a leading zero
        }
        
        // 2. Process Month: Map the 3-letter abbreviation to its 2-digit string
        String monthNum = "";
        switch (month) {
            case "Jan": monthNum = "01"; break;
            case "Feb": monthNum = "02"; break;
            case "Mar": monthNum = "03"; break;
            case "Apr": monthNum = "04"; break;
            case "May": monthNum = "05"; break;
            case "Jun": monthNum = "06"; break;
            case "Jul": monthNum = "07"; break;
            case "Aug": monthNum = "08"; break;
            case "Sep": monthNum = "09"; break;
            case "Oct": monthNum = "10"; break;
            case "Nov": monthNum = "11"; break;
            case "Dec": monthNum = "12"; break;
        }
        
        // 3. Assemble and return the formatted date string
        return year + "-" + monthNum + "-" + dayNum;
    }
}
