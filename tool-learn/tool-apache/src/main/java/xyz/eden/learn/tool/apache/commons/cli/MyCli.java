package xyz.eden.learn.tool.apache.commons.cli;

import org.apache.commons.cli.*;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/21 15:56
 */
public class MyCli {

    /**
     * cli 的工作步骤:
     * 1. 定义阶段
     * 2. 解析阶段
     * 3. 询问阶段
     */
    class SolutionOfCli {

        /**
         * 1. 定义阶段
         *
         * @return
         */
        public Options defineCli() {
            Options options = new Options().addOption(new Option("h", "help", false, "Lists short help"))
                    .addOption(new Option("c", "configFile", true, "Name server config properties file"))
                    .addOption(new Option("p", "printConfigItem", false, "Print all config item"));
            return options;
        }

        public void analysisCli(String[] args, Options options) throws ParseException {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            HelpFormatter helpFormatter = new HelpFormatter();
            if (cmd.hasOption("h")) {
            }

        }
    }
}
