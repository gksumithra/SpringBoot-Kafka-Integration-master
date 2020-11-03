package com.application.appointmentConsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentScheduling {
	private Integer truckNumber;
	private Integer poNumber;
    private String dateOfAppointment;
}
