import xml.etree.ElementTree as ET
import pandas as pd


try:
    # XML file path
    xml_path = "/Users/ahan/Developer/IntelliJ-workspace/EECS-4313-Assignment-1/build/jacoco-reports/test/jacocoTestReport.xml"
    # Parse the XML file
    tree = ET.parse(xml_path)
    root = tree.getroot()

    # Store MC/DC analysis
    coverage_results = []
    total_covered = 0
    total_branches = 0

    # Find all class methods in the report
    for package in root.findall(".//package"):
        package_name = package.get("name")

        for class_element in package.findall("class"):
            class_name = class_element.get("name")

            for method in class_element.findall("method"):
                method_name = method.get("name")

                # Check branches (decision points)
                for counter in method.findall("counter[@type='BRANCH']"):
                    covered = int(counter.get("covered"))
                    missed = int(counter.get("missed"))

                    total = covered + missed
                    if total > 0:
                        coverage_percentage = (covered / total) * 100
                    else:
                        coverage_percentage = 0.0

                    # Approximate MC/DC check: If we covered at least half the conditions
                    mcdc_achieved = "Yes" if covered >= total / 2 else "No"

                    coverage_results.append({
                        "Package": package_name,
                        "Class": class_name,
                        "Method": method_name,
                        "Total Branches": total,
                        "Covered": covered,
                        "Missed": missed,
                        "MC/DC Achieved": mcdc_achieved,
                        "Coverage %": round(coverage_percentage, 2)
                    })

                    # Track total coverage stats
                    total_covered += covered
                    total_branches += total

    # Calculate overall coverage percentage
    overall_coverage = (total_covered / total_branches) * 100 if total_branches > 0 else 0.0

    # Add overall summary at the end
    coverage_results.append({
        "Package": "Overall",
        "Class": "-",
        "Method": "-",
        "Total Branches": total_branches,
        "Covered": total_covered,
        "Missed": total_branches - total_covered,
        "MC/DC Achieved": "-",
        "Coverage %": round(overall_coverage, 2)
    })


    df = pd.DataFrame(coverage_results)
    df.to_csv("mcdc_coverage_report.csv", index=False)

except FileNotFoundError:
    print(f"Error: The file {xml_path} was not found. Ensure JaCoCo has generated the XML report.")
