package utils;


public class CandidateValidation {

    public static boolean validateCandidate(String name, int age, String clan, String region, String interests){
        if (!name.isEmpty() && age != 0 && !clan.isEmpty() && !region.isEmpty() && !interests.isEmpty()) {
            return true;
        } else
            return false;
    }
}
