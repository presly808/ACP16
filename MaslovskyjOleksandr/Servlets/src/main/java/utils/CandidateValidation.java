package utils;


public class CandidateValidation {

    public static boolean validateCandidate(String name, int age, String clan, String region, String interests){
        if (name != null && age != 0 && clan != null && region != null && interests != interests) {
            return true;
        } else
            return false;
    }
}
