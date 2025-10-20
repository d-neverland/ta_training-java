package com.epam.training.dariia_binevych.contact_book_exercise;

public class Contact {

    private String name;
    private ContactInfo phoneNumber;
    private final ContactInfo[] emails = new ContactInfo[3];
    private final ContactInfo[] socials = new ContactInfo[5];

    private int emailCount = 0;
    private int socialCount = 0;

    public Contact(String contactName) {
        this.name = contactName;

    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return name;
        }
    }

    public static class Email implements ContactInfo {
        private final String title;
        private final String value;

        public Email(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String value;

        public Social(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public void rename(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            name = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (emailCount >= 3) return null;
        Email email = new Email("Email", localPart + "@" + domain);
        emails[emailCount++] = email;
        return email;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (emailCount >= 3) return null;
        Email email = new Email("Epam Email", firstname + "_" + lastname + "@epam.com") {
        };
        emails[emailCount++] = email;
        return email;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (phoneNumber != null) return null;
        phoneNumber = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };
        return phoneNumber;
    }

    public Social addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public Social addSocialMedia(String title, String id) {
        if (socialCount >= 5) return null;
        Social social = new Social(title, id);
        socials[socialCount++] = social;
        return social;
    }

    public ContactInfo[] getInfo() {
        int total = 1 + (phoneNumber != null ? 1 : 0) + emailCount + socialCount;
        ContactInfo[] result = new ContactInfo[total];
        int idx = 0;
        result[idx++] = new NameContactInfo();
        if (phoneNumber != null) result[idx++] = phoneNumber;
        for (int i = 0; i < emailCount; i++) result[idx++] = emails[i];
        for (int i = 0; i < socialCount; i++) result[idx++] = socials[i];
        return result;
    }
}