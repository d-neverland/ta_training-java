package com.epam.training.dariia_binevych.new_post_office_exercise;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NewPostOffice {
    private final Collection<Box> listBox;
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    public static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    public boolean addBox(String addresser, String recipient, double weight, double volume, int value) {
        if (addresser == null || addresser.trim().isEmpty() ||
                recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender and recipient must exist.");
        }

        if (weight < 0.5 || weight > 20.0) {
            throw new IllegalArgumentException("Weight must be between 0.5 and 20.0 kg.");
        }

        if (volume <= 0.0 || volume > 0.25) {
            throw new IllegalArgumentException("Volume must be greater than 0 and less than or equal to 0.25 m³.");
        }

        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive.");
        }

        BigDecimal cost = calculateCostOfBox(weight, volume, value)
                .setScale(15, RoundingMode.HALF_EVEN);

        Box box = new Box(addresser, recipient, weight, volume);
        box.setCost(cost);
        listBox.add(box);
        return true;
    }

    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient must not be empty.");
        }

        List<Box> delivered = new ArrayList<>();
        Iterator<Box> iterator = listBox.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (recipient.equals(box.getRecipient())) {
                delivered.add(box);
                iterator.remove();
            }
        }
        return delivered;
    }

    public void declineCostOfBox(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percent must be non-negative.");
        }

        for (Box box : listBox) {
            BigDecimal current = box.getCost();
            if (current == null) continue;

            BigDecimal multiplier = BigDecimal.valueOf(1.0 - percent / 100.0);
            BigDecimal newCost = current.multiply(multiplier, MathContext.DECIMAL64)
                    .setScale(15, RoundingMode.HALF_EVEN);
            box.setCost(newCost);

        }
    }

}
