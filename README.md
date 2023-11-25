

# Financial Wisdom (FinWis)

Writeen by: Oshan Maharjan

Time spent: 5 hours spent in total

## Summary

Financial Wisdom is a comprehensive Android app designed for effective financial planning. 
Users can input their hourly rate, tax rate, and target amount, while a date picker ensures practical deadlines. 
The app calculates the average weekly hours needed to meet financial goals, considering factors like hourly rate, tax rate, and time remaining.
With a user-friendly interface and robust error handling, Financial Wisdom provides valuable insights, including alerts if the calculated average exceeds a maximum weekly limit.
In essence, it's a powerful tool for users seeking clarity and control in their financial journeys.

## Application Features

- [x] User Input Fields: The app includes input fields (EditText) for hourly rate, tax rate, and target amount.
- [x] Date Picker: A Button triggers a date picker dialog, allowing users to select a deadline for their financial goal.
- [x] Calculation Functionality: The app calculates the average hours per week needed to reach the financial target by the selected deadline.
                                 Factors considered include hourly rate, tax rate, and the target amount.
- [x] Result Display: The calculated average hours per week are displayed in a TextView on the app interface.
                      Specific messages are shown based on calculations, such as notifying the user if their hourly rate is considered low for the target.
- [x] Date Formatting: The selected date in the date picker is formatted using SimpleDateFormat to display in the "MMM dd yyyy" format.
- [x] Error Handling: The app checks for empty input fields to ensure users provide all required information.
- [x] Date Validation: The date picker ensures that the selected deadline is not in the past.





## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<img src='https://github.com/oshanma/Financial-Wisdom/assets/134091025/21b704fe-961e-47c5-8c8a-f987286b919d' title='Video Demo' width='' alt='Video Demo' />

GIF created with Kap


## License

Copyright 2023 Oshan Maharjan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
