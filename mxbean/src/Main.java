package src;

import com.sun.tools.attach.*;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.File;
import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {

        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        System.out.println(vms);

        VirtualMachine vm = VirtualMachine.attach(args[0]);
        System.out.println(vm);

        String CONNECTOR_ADDRESS = "com.sun.management.jmxremote.localConnectorAddress";
        String connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);
        if (connectorAddress == null) {

            String agent = vm.getSystemProperties().getProperty("java.home") +
                    File.separator + "lib" + File.separator + "management-agent.jar";
            vm.loadAgent(agent);

            System.out.println("agent loaded.");

            connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);
        }

        vm.detach();

        JMXServiceURL url = new JMXServiceURL(connectorAddress);

        System.out.println("Service URL = " + connectorAddress);

        try (JMXConnector connector = JMXConnectorFactory.connect(url)) {
            MBeanServerConnection connection = connector.getMBeanServerConnection();

            MemoryMXBean memoryMXBean = ManagementFactory
                    .newPlatformMXBeanProxy(connection, ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);

            System.out.println(memoryMXBean.getHeapMemoryUsage());
            System.out.println(memoryMXBean.getObjectPendingFinalizationCount());
            System.out.println(memoryMXBean.getNonHeapMemoryUsage());
            System.out.println(memoryMXBean.getObjectName());

            ClassLoadingMXBean classLoadingMXBean = ManagementFactory
                    .newPlatformMXBeanProxy(connection, ManagementFactory.CLASS_LOADING_MXBEAN_NAME, ClassLoadingMXBean.class);
            System.out.println(classLoadingMXBean.getLoadedClassCount());
            System.out.println(classLoadingMXBean.getTotalLoadedClassCount());
            System.out.println(classLoadingMXBean.getUnloadedClassCount());
            System.out.println(classLoadingMXBean.getObjectName());

            RuntimeMXBean runtimeMXBean = ManagementFactory
                    .newPlatformMXBeanProxy(connection, ManagementFactory.RUNTIME_MXBEAN_NAME, RuntimeMXBean.class);
            System.out.println(runtimeMXBean.getBootClassPath());
        }
    }
}
