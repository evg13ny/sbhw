public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов

        float min = 32;
        float max = 40;

        float[] patientTemperatures = new float[patientsCount];

        for (int i = 0; i < patientTemperatures.length; i++) {
            patientTemperatures[i] = (float) ((Math.random() * (max - min)) + min);
            patientTemperatures[i] = (Math.round(patientTemperatures[i] * 10f) / 10f);
        }

        return patientTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        String temperatureList = "";
        int countHealthyPatients = 0;
        float sumTemperatures = 0;

        for (int i = 0; i < temperatureData.length; i++) {
            temperatureList = temperatureList + " " + temperatureData[i];
            sumTemperatures = sumTemperatures + temperatureData[i];
            if (temperatureData[i] >= 36.2f && temperatureData[i] <= 36.9f) {
                countHealthyPatients++;
            }
        }

        float averageTemperature = (Math.round((sumTemperatures / temperatureData.length) * 100f) / 100f);

        return "Температуры пациентов: " + temperatureList.trim() +
                "\nСредняя температура: " + averageTemperature +
                "\nКоличество здоровых: " + countHealthyPatients;
    }
}
