while (s.length() != 0) {
            if(s.charAt(0) == s.charAt(s.length()-1)) {
                s = s.substring(1, s.length()-1);
            }
            else {
                return s.length();
            }
        }
        return 0;