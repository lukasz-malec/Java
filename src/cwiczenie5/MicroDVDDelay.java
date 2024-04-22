package cwiczenie5;

public class MicroDVDDelay {

    public static String delay(String in, int delay, int fps) throws MicroException {
        StringBuilder t = new StringBuilder();
        String[] lines = in.split("\n");
        int previous = -1;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String formatted = line.replace("{", "");

            if (line.length() - 1 <= formatted.length()) {
                throw new MicroException("Missing {", (i + 1));
            }

            String[] elements = formatted.split("}");

            if (elements.length < 3) {
                throw new MicroException("Missing }", (i + 1));
            }

            int startFrame;
            int endFrame;
            try {
                startFrame = Integer.parseInt(elements[0]);
                endFrame = Integer.parseInt(elements[1]);
            } catch (NumberFormatException e) {
                throw new MicroException("NOt numbet", i + 1);
            }

            if (startFrame >= endFrame) {
                throw new MicroException("From must be less than To", i + 1);
            }

            if (startFrame < previous) {
                throw new MicroException("From must be greater or equal than previous To", i + 1);
            }
            previous = endFrame;

            String text = elements[2];

            int frameDelay = (fps * delay) / 1000;
            startFrame += frameDelay;
            endFrame += frameDelay;

            t.append("{").append(startFrame).append("}").append("{").append(endFrame).append("}").append(text).append("\n");
        }

        return t.toString();
    }
}